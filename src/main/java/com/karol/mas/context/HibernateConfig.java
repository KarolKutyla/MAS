package com.karol.mas.context;

import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class HibernateConfig {
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.community.dialect.SQLiteDialect"); // Dialekt bazy danych
        properties.setProperty("hibernate.show_sql", "true"); // Pokazywanie SQL w logach
        properties.setProperty("hibernate.format_sql", "true"); // Formatowanie SQL
        properties.setProperty("hibernate.hbm2ddl.auto", "update"); // Automatyczne aktualizowanie schematu bazy danych
//            properties.setProperty("hibernate.id.db_structure_naming_strategy", "legacy");
        return properties;
    }


}
