package pe.jiyoung.newtoy.spring.mybatis.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import pe.jiyoung.newtoy.spring.common.db.dao.GenericMybatisDao;


public abstract class GenericDaoMybatisImpl<T> extends SqlSessionDaoSupport implements GenericMybatisDao<T>{

    @Autowired
    @Override
    public void setSqlSessionFactory(final SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    private final Class<T> type;

    public GenericDaoMybatisImpl() {
        final Type t = this.getClass().getGenericSuperclass();
        final ParameterizedType pt = (ParameterizedType) t;
        this.type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public long countAll(final String statement, final Map<String, Object> identifier) {
        return (long) this.getSqlSession().selectOne(statement, identifier);
    }

    @Override
    public long countAll(final String statement) {
        return (long) this.getSqlSession().selectOne(statement);
    }

    @Override
    public int create(final String statement, final Object t) {
        return this.getSqlSession().insert(statement, t);
    }

    @Override
    public int delete(final String statement, final Object id) {
        return this.getSqlSession().delete(statement, id);
    }

    @Override
    public T find(final String statement, final Object params) {
        return this.getSqlSession().selectOne(statement, params);
    }

    @Override
    public int update(final String statement, final Object params) {
        return this.getSqlSession().update(statement, params);
    }

    @Override
    public List<T> getAll(final String statement) {
        return this.getSqlSession().selectList(statement);
    }

    @Override
    public List<T> getList(final String statement, final Object params) {
        return this.getSqlSession().selectList(statement, params);
    }


}
