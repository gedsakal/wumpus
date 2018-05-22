package com.hunter;

import com.hunter.model.Labyrinth;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class GameInitializerTest {


    @Test
    public void InitializeLabyrinthTest() throws Exception {
        String input = " 5\n 4\n 6\n";
        System.out.println("-Parameters: \n" + input);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Labyrinth lab = GameInitializer.initLabyrinth();

        assert lab != null;
        assert lab.getWidth() == 5;
    }

    /**
     * Test if parameters for configuration makes impossible to configure for win
     * @throws Exception
     */
    @Test
    public void InitializeLabyrinthWrongParametersTest() throws Exception {
        String input = " 4\n 3\n 7\n";
        System.out.println("-Parameters: \n" + input);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Labyrinth lab = GameInitializer.initLabyrinth();

        assert lab != null;
        assert lab.getWidth() == 4;
    }


}
