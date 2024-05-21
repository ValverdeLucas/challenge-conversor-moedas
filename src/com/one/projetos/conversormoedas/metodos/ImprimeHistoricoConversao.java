package com.one.projetos.conversormoedas.metodos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ImprimeHistoricoConversao {

    public void imprimeHistorico(List historico) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        File file = new File("historico-conversoes.json");
        FileWriter writer = new FileWriter(file);

        writer.write(gson.toJson(historico));
        System.out.println("Arquivo gerado com sucesso! Arquivo salvo em: " + file.getAbsolutePath());
        writer.close();

    }
}
