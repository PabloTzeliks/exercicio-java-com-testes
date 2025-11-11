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

        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarPorId(int id) throws SQLException, IllegalArgumentException {

        Produto produto = produtoRepository.findById(id);

        if (produto == null) {
            throw new IllegalArgumentException("Produto de ID: " + id + ", não foi encontrado.");
        }

        return produto;
    }

    @Override
    public Produto atualizarProduto(Produto produto, int id) throws SQLException {

        // Adiciona ID
        produto.setId(id);

        return produtoRepository.update(produto);
    }

    @Override
    public boolean excluirProduto(int id) throws SQLException {
        return false;
    }
}
