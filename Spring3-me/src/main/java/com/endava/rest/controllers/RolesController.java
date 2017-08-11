package com.endava.rest.controllers;

import com.endava.rest.config.PostgreSQLJDBC;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.UUID;

@RestController
public class RolesController {

    @GetMapping(value = "/roles", produces = "application/json")
    public String getRoles() {

        Connection c = null;
        Statement stmt = null;

        Writer writer = new StringWriter();
        JsonGenerator generator = Json.createGenerator(writer);
        String json = null;

        try {
            c = PostgreSQLJDBC.dbConnector();
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT roles.id, roles.role FROM roles; ");

            generator.writeStartObject();
            generator.writeStartArray("roles");

            while (rs.next()) {
                String id = rs.getString("id");
                String role = rs.getString("role");

                generator.writeStartObject()
                        .write("id", id)
                        .write("role", role)
                        .writeEnd();
            }

            generator.writeEnd();
            generator.writeEnd();
            generator.close();

            rs.close();
            stmt.close();
            c.close();
            json = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    @PostMapping(value = "/roles/{role}")
    public void addRole(@PathVariable("role") String role) {


        Integer id = 0 + (int)(Math.random() * 300);
        Connection c = null;
        Statement stmt = null;
        String sql;

        try {
            c = PostgreSQLJDBC.dbConnector();
            c.setAutoCommit(false);
            stmt = c.createStatement();
            System.out.println("post");
            sql = "INSERT INTO roles (id, role) "
                    + "VALUES ('" + id + "', '" + role +"');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(value = "/roles/{id}")
    public void removeItem(@PathVariable("id") String id) {

        Connection c = null;
        Statement stmt = null;

        try {
            c = PostgreSQLJDBC.dbConnector();
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "DELETE from roles where id = '"+id+"';";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
