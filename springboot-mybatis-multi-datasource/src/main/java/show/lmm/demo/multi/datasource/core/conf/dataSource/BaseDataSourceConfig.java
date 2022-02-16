package show.lmm.demo.multi.datasource.core.conf.dataSource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 基础数据源配置
 * @author 刘明明
 * @date 2022-02-16 14:58:53
 */
public abstract class BaseDataSourceConfig {

    /**
     * 获得sqlSessionFactory
     *
     * @param datasource:      数据源
     * @param locationPattern: mapper路径
     * @return org.apache.ibatis.session.SqlSessionFactory
     * @since 刘明明/2022-02-16 15:02:34
     **/
    public SqlSessionFactoryBean getSqlSessionFactory(DataSource datasource, String locationPattern) throws Exception {
        Configuration configuration = new Configuration();
        return new SqlSessionFactoryBean() {{
            setDataSource(datasource);
            setConfiguration(configuration);
            setMapperLocations(new PathMatchingResourcePatternResolver().getResources(locationPattern));
        }};
    }

    /**
     * @Bean 注册Bean对象
     * @Primary 表示默认数据源
     * @ConfigurationProperties 读取properties中的配置参数映射成为一个对象
     */
    public abstract HikariDataSource getDateSource();

    /**
     * @param dataSource 数据源
     * @return SqlSessionFactory
     * @Primary 默认SqlSessionFactory
     */
    public abstract SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception;

    /**
     * 初始化SqlSessionTemplate
     *
     * @param sqlSessionFactory:
     * @return org.mybatis.spring.SqlSessionTemplate
     * @since 刘明明/2022-02-16 15:02:49
     **/
    public abstract SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory);

    /**
     * 事务管理器
     *
     * @param dataSource:  数据源
     * @return org.springframework.jdbc.datasource.DataSourceTransactionManager
     * @since 刘明明/2022-02-16 15:03:11
     **/
    public abstract DataSourceTransactionManager transactionManager(DataSource dataSource);
}
