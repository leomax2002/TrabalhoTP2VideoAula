//package com.beginsecure.domain;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import java.io.IOException;


public class ControlerTest {

    //public Model mockModel = mock(Model.class);
    //public View mockView = mock(View.class);
    private Controler mockControler = new Controler();

    @Test
    void givenName_whenReadWithSystemLambda_thenReturnCorrectResult() throws Exception {
        // Executa o método do controlador que realiza a interação
        // Simula a entrada do usuário
        withTextFromSystemIn("C:/Users/leoma/IdeaProjects/Test/src/main/java/teste.txt\n5\n0\n1")
                .execute(() -> assertEquals(null,  mockControler.realizaInterface()));
    }
   @Test
    void testInteraction() {
        // Simula o caminho do arquivo
        String filePath = "C:/Users/leoma/IdeaProjects/Test/src/main/java/teste.txt";
        // Verifica se o método do modelo foi chamado com o caminho do arquivo
       assertTrue(mockControler.model.contarPalavras(filePath).containsValue(1));
        // Verifica se o método do controler foi chamado para carregar o arquivo
        mockControler.caregarWordCount(filePath);
        // Verifica se o método da view foi chamado para apresentar a contagem de palavras
       assertInstanceOf(AbstractList.class, mockControler.view.apresentarArrayWordCount(1, 1, -1));
    }
}