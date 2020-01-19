open module be.syntra.java.advanced.springmvc {
    requires spring.core;
    requires spring.context;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;

    // MVC
    requires spring.web;
    requires java.annotation;
    requires spring.boot.starter.web;
    requires spring.webmvc;
    requires java.validation;
    requires org.apache.tomcat.embed.core;
    requires spring.data.commons;
    requires spring.security.config;

    // PERSISTENCE
    requires java.sql;
    requires java.persistence;
    requires spring.data.jpa;
    requires net.bytebuddy;
    requires com.fasterxml.classmate;
}
