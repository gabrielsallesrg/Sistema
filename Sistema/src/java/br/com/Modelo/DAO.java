package br.com.Modelo;

import br.com.library.GeraToken;
import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private final Connection conn;
    private ResultSet rs;    
    // método construtor para conectar com o banco
    
    public DAO () throws SQLException {
        System.out.println("DAO.java, construtor");
        this.conn = (Connection) FabricaDeConexão.getConnection();
        System.out.println("DAO.java, fim do construtor");
    } //construtor     
    
    public int retornaIdCliente(String nome){   
        
        int idCliente = 0;
        
        try{
            
            String SQL = " SELECT idCliente from cliente where nomeUsuario = ?";                   
            PreparedStatement stmt = this.conn.prepareStatement(SQL);  
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();  
            
            while(rs.next()){
                idCliente = rs.getInt("idCliente");
            }
            rs.close();
            stmt.close();
            
            return idCliente; 
            
        }catch(Exception e){
            throw new RuntimeException(e);
        }    
    } //listaPedidos
    
     public cliente retornaCadastroCliente(Usuario user){   
        
      
        try{
            
            String SQL = " SELECT * from cliente where nomeUsuario = ?";                   
            PreparedStatement stmt = this.conn.prepareStatement(SQL);  
            stmt.setString(1,user.getNome());
            ResultSet rs = stmt.executeQuery();  
            
            cliente client = new cliente();
            
            while(rs.next()){
                client.setIdCliente(rs.getInt("idCliente"));
                client.setCidade(rs.getString("cidade"));
                client.setEmail(rs.getString("Email"));
                client.setEndereco(rs.getString("endereco"));
                client.setNome(rs.getString("nome"));
                client.setSobrenome(rs.getString("sobrenome"));
                client.setTelefone(rs.getString("telefone"));
            }
            rs.close();
            stmt.close();
            
            return client; 
            
        }catch(Exception e){
            throw new RuntimeException(e);
        }    
    } //listaPedidos
    
    
    /////////////////ADICIONAR TABELAS////////////////////
    
    public void cadastrarPedido(int[] idProduto, int[] quantidade, int idCliente) {
        final int index = idProduto.length; //recebe o tamanho do vetor
        double[] precos = new double[index];
        String SQL;      
        try {                 
            for (int i=0; i<index; i++) { //carregando o array preços.
                SQL = "SELECT valor FROM Produtos WHERE idProduto LIKE ?";
                PreparedStatement ps = this.conn.prepareStatement(SQL);
                ps.setInt(1,idProduto[i]);
                ResultSet rs = ps.executeQuery();
                precos[i] = rs.getDouble("valor"); //recebe o retorno do select do banco
                precos[i] *= quantidade[i]; //multiplica o preço pela quantidade para chegar no valor total do pedido.
                rs.close();
                ps.close(); 
                SQL = "";
            } //for
            for (int i=0; i<index; i++) { //adiciona os pedidos ao banco de dados.
                pedido p = new pedido(); //settando a variavel p
                p.setQuantidade(quantidade[i]);
                p.setIdCliente(idCliente);
                java.util.Date data = new java.util.Date();
                p.setEmissao(data);
                p.setSituacao('A');
                p.setPagamento("De");
                GeraToken gt = new GeraToken();
                p.setToken(gt.TOKEN());
                p.setIdProduto(idProduto[i]);
                SQL = "INSERT INTO Pedido (Produtos_idProduto, Quantidade, Valor, Situacao, Cliente_idCliente, TOKEN, Emissao, Pagamento) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(SQL);
                ps.setInt(1, p.getIdProduto());
                ps.setDouble(2, p.getQuantidade());
                ps.setDouble(3, p.getValor());
                ps.setString(4, ""+p.getSituacao());
                ps.setInt(5, p.getIdCliente());
                ps.setString(6, p.getToken());
                ps.setDate(7, convertDate(p.getEmissao()));
                ps.setString(8, p.getPagamento());
                ps.execute();
                ps.close();
            } 
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    }
    
    public void adicionaCliente (cliente Cliente) { //rever a string sql. idCliente deve ter auto-incremento
        String SQL = "INSERT INTO Cliente (Nome, Sobrenome, Endereco, Telefone, Cidade, Email, nomeUsuario) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, Cliente.getNome());
            ps.setString(2, Cliente.getSobrenome());
            ps.setString(3, Cliente.getEndereco());
            ps.setString(4, Cliente.getTelefone());
            ps.setString(5, Cliente.getCidade());
            ps.setString(6, Cliente.getEmail());  
            ps.setString(7, Cliente.getNomeUsuario());
            ps.execute(); //executa os comandos no db.
            ps.close(); //finalize conexão com o db.
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //adicionarCliente
    
    public void cadastroProduto (produtos Produto) throws SQLException {
        
        // Este metodo testara se o produto ja esta cadastrado.
        // Caso esteja, ira atualizar os dados.
        // Caso nao esteja, ira adiciona-lo na tabela Produto.
        
        List <produtos> listaProd =  new ArrayList<produtos>();
        String SQL = "SELECT * FROM Produtos WHERE descricao = '" + Produto.getDescricao() + "'";
        System.out.println("DAO.java, linha 120, SQL = " + SQL);
        PreparedStatement stmt = this.conn.prepareStatement(SQL);
        ResultSet rs = stmt.executeQuery();            
        while(rs.next()){
            produtos prod = new produtos();                
            prod.setDescricao(rs.getString("descricao"));
            prod.setEstoque(rs.getInt("estoque"));
            prod.setIdProduto(rs.getInt("idProdutos"));
            prod.setValor(rs.getDouble("valor"));
            listaProd.add(prod);
        }
        rs.close();
        stmt.close();
        if (listaProd.size() > 0) {
            // Se a lista tiver ao menos 1 elemento, o produto ja esta cadastrado.
            System.out.println("DAO.java, linha 132, Produto ja na lista");
            SQLException e = new SQLException("Produto ja no BD");
            throw new RuntimeException(e);
            //Produto.setIdProduto(listaProd.get(0).getIdProduto());
            //alteraProduto(Produto);
        }
        else{
            // Senao insere o produto
            SQL = "INSERT INTO Produtos (descricao, valor, estoque, Situacao)"+" VALUES (?,?,?,?)";
            try {
                PreparedStatement ps = conn.prepareStatement(SQL);
                ps.setString(1, Produto.getDescricao());
                String aux = Double.toString(Produto.getValor());
                ps.setString(2, aux);
                aux = Integer.toString(Produto.getEstoque());
                ps.setString(3, aux);
                aux = "" + Produto.getSituacao();
                ps.setString(4, aux);
                ps.execute();
                ps.close();
            } //try
            catch (SQLException e) {
                throw new RuntimeException(e);
            } //catch
        }
    } //cadastrarProduto
    
    public void removerPedido (int idPedido) throws SQLException {
        
        // Apos a retirada do pedido no estabelecimento, sera removido o pedido da tabela
        // delete from Pedido where idPedido = 3
        
        String SQL = "DELETE FROM Pedido WHERE idPedido = " + idPedido;
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.execute();
            ps.close();
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
        
    } //removerPedido
    
    ////////////////////LISTAR E CONSULTAR TABELAS///////////////
    public List<produtos> listaProdutos() {            
        try {
            List<produtos> aut = new ArrayList<produtos>();
            String SQL = "SELECT * FROM Produtos";
            PreparedStatement stmt = this.conn.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();            
            while(rs.next()){
                produtos prod = new produtos();                
                prod.setDescricao(rs.getString("descricao"));
                prod.setEstoque(rs.getInt("estoque"));
                prod.setIdProduto(rs.getInt("idProdutos"));
//                prod.setUnidades(rs.getString("unidade"));
                prod.setValor(rs.getDouble("valor"));
                prod.setSituacao(rs.getString("situacao"));
                aut.add(prod);
            }
            rs.close();
            stmt.close();
            return aut;
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //listaProdutos
    
    public List<pedido> listaPedidos(int idCliente){        
        try{
            String SQL = " SELECT * FROM Pedido WHERE Cliente_idCliente LIKE ?";          
            List<pedido> aut = new ArrayList<pedido>();            
            PreparedStatement stmt = this.conn.prepareStatement(SQL);  
            stmt.setInt(1,idCliente);
            ResultSet rs = stmt.executeQuery();            
            while(rs.next()){
                pedido ped = new pedido();                
                ped.setEmissao(rs.getDate("emissao"));
                ped.setIdPedido(rs.getInt("idPedido"));
                ped.setPagamento(rs.getString("pagamento"));
                ped.setQuantidade(rs.getInt("quantidade"));
                ped.setRetirada(rs.getDate("retirada"));
                ped.setToken(rs.getString("token"));
                ped.setValor(rs.getFloat("valor"));                
                aut.add(ped);
            }
            rs.close();
            stmt.close();
            return aut;            
        }catch(Exception e){
            throw new RuntimeException(e);
        }    
    } //listaPedidos
    
    public List<produtos> consultaIdProduto (produtos Produto) {
        try {
            int idProdutos = Produto.getIdProduto();
            List<produtos> listaProdutos = new ArrayList<produtos>(); //cria uma lista do tipo Autores
            String SQL = "SELECT * FROM Produtos WHERE idProdutos LIKE ?";  //frase SQL          
            PreparedStatement st = this.conn.prepareStatement(SQL); //manda a frase para o banco
            st.setString(1,Integer.toString(idProdutos));
            ResultSet rs = st.executeQuery(); //executa a frase SQL e recebe o resultado do retorno do banco
            while (rs.next()) { //enquanto houver item na lista
                produtos po = new produtos(); //cria um novo objeto                
                po.setDescricao(rs.getString("descricao"));
                po.setEstoque(rs.getInt("estoque"));
                po.setIdProduto(rs.getInt("idProdutos"));
                po.setSituacao(rs.getString("Situacao")); //função que recebe o index 1 da String "rs.getString("Situacao").
                po.setValor(rs.getDouble("valor"));                
                listaProdutos.add(po); //adiciona o objeto à lista
            } //while
            rs.close();
            st.close();
            return listaProdutos;
        } //try
        catch (SQLException erro) {
            throw new RuntimeException(erro);
        } //catch
    }
    
       public String nomeProdutoByID(int idProd) {            
        try {
            produtos prod = new produtos();
            String SQL = "SELECT descricao FROM Produtos WHERE idProdutos = " + idProd;
            PreparedStatement stmt = this.conn.prepareStatement(SQL);  
            ResultSet rs = stmt.executeQuery();            
            while(rs.next()){
                prod.setDescricao(rs.getString("descricao"));
            }
            rs.close();
            stmt.close();
            return prod.getDescricao();
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //listaProdutos
    
    
    public List<pedido> listaPedidobyToken(pedido pedid) {            
        try {
            List<pedido> aut = new ArrayList<pedido>();
            String SQL = "SELECT * FROM Pedido WHERE token = ?";
            
            PreparedStatement stmt = this.conn.prepareStatement(SQL);  
            stmt.setString(1, pedid.getToken());
            ResultSet rs = stmt.executeQuery();            
            
            
            while(rs.next()){
                pedido ped = new pedido();                
                ped.setEmissao(rs.getDate("emissao"));
                ped.setIdPedido(rs.getInt("idPedido"));
                ped.setIdProduto(rs.getInt("Produtos_idProdutos"));
                ped.setPagamento(rs.getString("pagamento"));
                ped.setQuantidade(rs.getInt("quantidade"));
                ped.setRetirada(rs.getDate("retirada"));
                ped.setToken(rs.getString("token"));
                ped.setValor(rs.getFloat("valor"));                
                aut.add(ped);
            }
            
            rs.close();
            stmt.close();
            return aut;
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //listaProdutos
    
    
    public List<pedido> listaPedidobyToken_2(pedido p) {            
        try {
            List<pedido> aut = new ArrayList<pedido>();
            String token = p.getToken();
            String SQL = "SELECT * FROM Pedido WHERE token = " + token;
            
            PreparedStatement stmt = this.conn.prepareStatement(SQL);  
            ResultSet rs = stmt.executeQuery();            
            
            while(rs.next()){
                pedido ped = new pedido();                
                ped.setEmissao(rs.getDate("emissao"));
                ped.setIdPedido(rs.getInt("idPedido"));
                ped.setPagamento(rs.getString("pagamento"));
                ped.setQuantidade(rs.getInt("quantidade"));
                if (rs.getDate("retirada") == null){
                    ped.setRetirada(null);
                }
                else{
                    ped.setRetirada(rs.getDate("retirada"));
                }
                ped.setToken(rs.getString("token"));
                ped.setValor(rs.getFloat("valor"));                
                aut.add(ped);
            }
            
            rs.close();
            stmt.close();
            return aut;
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //listaProdutos
    
    ////////////ALTERAR TABELAS/////////////
    public void alteraProduto (produtos Produto) {
        String SQL = "UPDATE Produtos SET valor = " + Produto.getValor() + ", estoque = " + Produto.getEstoque() + " , situacao = '" + Produto.getSituacao() + "' WHERE idProdutos LIKE " + Produto.getIdProduto();
        System.out.println("DAO.java, 303, SQL = " + SQL);
        try {
            System.out.println("DAO.java, 305, try");
            PreparedStatement ps = conn.prepareStatement(SQL);
            /*ps.setString(1, Produto.getDescricao());
            ps.setDouble(2, Produto.getValor());
            ps.setInt(3, Produto.getEstoque());
            ps.setString(4, ""+Produto.getSituacao());
            ps.setInt(5, Produto.getIdProduto()); */
            ps.execute();
            ps.close();
        }
        catch (SQLException e) {
            System.out.println("DAO.java, 305, catch");
            throw new RuntimeException(e);
        } //catch
    } //alteraProduto
    
    public void alteraEstoque (produtos Produto) {
        String SQL = "UPDATE Produtos SET estoque=? WHERE idProdutos LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, Produto.getEstoque());
            ps.setInt(2, Produto.getIdProduto());
            ps.execute();
            ps.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //alteraProduto
    
    public void alteraCliente (cliente cli) {
        String SQL = "UPDATE cliente SET nome = ?, sobrenome = ?, Endereco = ?, "+
                    " telefone = ?, cidade = ?, email = ? WHERE idCliente = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, cli.getNome());
            ps.setString(2, cli.getSobrenome());
            ps.setString(3, cli.getEndereco());
            ps.setString(4, cli.getTelefone());
            ps.setString(5, cli.getCidade());
            ps.setString(6, cli.getEmail());
            ps.setInt(7, cli.getIdCliente());
            
            ps.execute();
            ps.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //alteraProduto
    
    /////////MÉTODOS DE REMOÇÃO//////////
    public void removerPedido(pedido p) {
        String SQL = "DELETE FROM Pedido WHERE idPedido LIKE ?";
        try {            
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, p.getIdPedido()); //setando o valor "?" da string SQL com o valor correto do objeto que será apagado.
            stmt.execute();
            stmt.close();
        } //try
        catch (SQLException e) {
            throw new RuntimeException(e);
        } //catch
    } //removerAutores
    
    /////////Método de conversão http://stackoverflow.com/questions/530012/how-to-convert-java-util-date-to-java-sql-date//////////
    public java.sql.Date convertDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
} //class
