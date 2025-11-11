package org.example.service;

import org.example.model.Produto;
import org.example.repository.ProdutoRepository;

import java.sql.SQLException;
import java.util.List;

public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto cadastrarProduto(Produto produto) throws SQLException, IllegalArgumentException {

        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("Preço deve ser positivo.");
        }

        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listarProdutos() throws SQLException {
        return List.of();
    }

    @Override
    public Produto buscarPorId(int id) throws SQLException {
        return null;
    }

    @Override
    public Produto atualizarProduto(Produto produto, int id) throws SQLException {
        return null;
    }

    @Override
    public boolean excluirProduto(int id) throws SQLException {
        return false;
    }
}
