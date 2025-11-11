package org.example.repository;

import org.example.model.Produto;
import org.example.util.ConexaoBanco;

import java.sql.*;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class ProdutoRepositoryImpl implements ProdutoRepository{

    @Override
    public Produto save(Produto produto) throws SQLException {

        Produto produtoPersistency = null;

        String querySave = """
                INSERT INTO produto (nome, preco, quantidade, categoria) VALUES (?, ?, ?, ?);
                """;

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(querySave, RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4, produto.getCategoria());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {

                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {

                    int id = rs.getInt(1);

                    produtoPersistency = new Produto(
                            id, produto.getNome(),
                            produto.getPreco(),
                            produto.getQuantidade(),
                            produto.getCategoria()
                    );
                }
            }
        }

        return produtoPersistency;
    }

    @Override
    public List<Produto> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public Produto findById(int id) throws SQLException {
        return null;
    }

    @Override
    public Produto update(Produto produto) throws SQLException {
        return null;
    }

    @Override
    public void deleteById(int id) throws SQLException {

    }
}
