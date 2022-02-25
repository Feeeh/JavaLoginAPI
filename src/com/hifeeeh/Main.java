package com.hifeeeh;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hifeeeh.Models.Usuario;

public class Main {

    public static void main(String[] args) {
        String mainUrl = "https://localhost:44356/";
        try {
            URL getUsuarios = new URL(mainUrl + "Api/GetUsuario");
            HttpURLConnection conn = (HttpURLConnection) getUsuarios.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200){
                throw new RuntimeException("Failed");
            }

            Type usuarioType = new TypeToken<ArrayList<Usuario>>(){}.getType();
            List<Usuario> usuarios = new Gson().fromJson(conn.getResponseMessage(), usuarioType);

            System.out.println(Arrays.toString(usuarios.toArray()));

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
