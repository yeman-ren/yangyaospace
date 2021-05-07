package com.yy.config;

import com.yy.pojo.Configuration;
import com.yy.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration =configuration;
    }


    public void parse(InputStream inputStream) throws DocumentException {
        //读取文档为 document
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();

        //读取命名空间的值
        String namespace = rootElement.attributeValue("namespace");

        //获取所有的select标签
        List<Element> list = rootElement.selectNodes("//select");
        for (Element element : list) {
            //读取里面的值
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String paramterType = element.attributeValue("paramterType");
            //具体的sql语句
            String sqlText = element.getTextTrim();
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParamterType(paramterType);
            mappedStatement.setSql(sqlText);
            //组装每条sql语句的唯一标识 即：namespace + "." + id
            String key = namespace+"."+id;
            configuration.getMappedStatementMap().put(key,mappedStatement);
        }


        // TODO 获取所有的 update 标签
        // TODO 获取所有的 delete 标签
        // TODO 获取所有的 insert 标签
    }
}
