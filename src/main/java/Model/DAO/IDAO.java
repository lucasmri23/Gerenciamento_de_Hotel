package Model.DAO;

import java.sql.Connection;

public interface IDAO<T> {
    
    String cadastrar(T entidade, Connection conexao);

    String atualizar(T entidade, Connection conexao);

    String excluir(Connection conexao, String remov);
    
    String excluir(Connection conexao, long remov);
    
    String excluir(Connection conexao, int remov);

    void listar(Connection conexao);
}
