package pe.jiyoung.newtoy.spring.common.db.dao;

import java.util.List;
import java.util.Map;

public interface GenericMybatisDao<T> {

    public long countAll(String statement, Map<String, Object> identifier);
    public long countAll(String statement);

    public int create(String statement, T t);

    public int delete(String statement, Object id);

    public T find(String statement, Object id);

    public int update(String statement, T t);

    public List<T> getAll(String statement);

    public List<T> getList(String statement, Object search);
}