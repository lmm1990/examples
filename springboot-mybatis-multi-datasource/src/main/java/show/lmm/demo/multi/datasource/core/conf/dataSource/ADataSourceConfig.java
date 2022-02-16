package show.lmm.demo.multi.datasource.core.conf.dataSource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import show.lmm.demo.multi.datasource.core.constant.TransactionManagerConstant;

import javax.sql.DataSource;

/**
 * a数据库数据源
 * @author 刘明明
 * @date 2022-02-16 15:07:46
 */
@Configuration
@MapperScan(basePackages = "show.lmm.demo.**.mapper.a", sqlSessionFactoryRef = "aSqlSessionFactory")
public class ADataSourceConfig extends BaseDataSourceConfig {

    /**
     * @Bean 注册Bean对象
     * @Primary 表示默认数据源
     * @ConfigurationProperties 读取properties中的配置参数映射成为一个对象
     */
    @Override
    @Primary
    @Bean(name = "aDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.a")
    public HikariDataSource getDateSource() {
        return new HikariDataSource();
    }

    /**
     * @param dataSource 数据源
     * @return SqlSessionFactory
     * @Primary 默认SqlSessionFactory
     */
    @Override
    @Primary
    @Bean(name = "aSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("aDataSource") DataSource dataSource) throws Exception {
        return getSqlSessionFactory(dataSource, "classpath*:mapper/a/*.xml").getObject();
    }

    @Override
    @Primary
    @Bean("aSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("aSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * a数据源事务管理器
     *
     * @param dataSource:  数据源
     * @return org.springframework.jdbc.datasource.DataSourceTransactionManager
     * @since 刘明明/2022-02-16 15:10:19
     **/
    @Bean(name = TransactionManagerConstant.A_TRANSACTION_MANAGER)
    @Override
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("aDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
