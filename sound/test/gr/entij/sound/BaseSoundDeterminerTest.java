/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.entij.sound;

import gr.entij.event.PositEvent;
import gr.entij.event.StateEvent;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sta
 */
public class BaseSoundDeterminerTest {
    
    static final long move1 = 0;
    static final long move2 = 1;
    
    static final long state1 = 0;
    static final long state2 = 1;
    
    static final String sound1 = "tada";
    static final String sound2 = "boom";
    
    public BaseSoundDeterminerTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of setSoundForPosit and getSoundForPosit methods, of class BaseSoundDeterminer.
     */
    @Test
    public void testSetGetSoundForPosit() {
        System.out.println("setSoundForPosit");
        BaseSoundDeterminer instance = new BaseSoundDeterminer();
        instance.setSoundForPosit(move1, sound1);
        assertEquals(sound1, instance.getSoundForPosit(new PositEvent(null, null, -1, move1)));
        
        instance.setSoundForPosit(move2, sound2);
        assertEquals(sound2, instance.getSoundForPosit(new PositEvent(null, null, -1, move2)));
        
        instance.setSoundForPosit(move1, sound2);
        assertEquals(sound2, instance.getSoundForPosit(new PositEvent(null, null, -1, move1)));
    }

    /**
     * Test of setSoundForState and getSoundForState methods, of class BaseSoundDeterminer.
     */
    @Test
    public void testSetGetSoundForState() {
        System.out.println("getSoundForState");
        BaseSoundDeterminer instance = new BaseSoundDeterminer();
        instance.setSoundForState(move1, sound1);
        assertEquals(sound1, instance.getSoundForState(new StateEvent(null, -1, state1)));
        
        instance.setSoundForState(move2, sound2);
        assertEquals(sound2, instance.getSoundForState(new StateEvent(null, -1, state2)));
        
        instance.setSoundForState(move1, sound2);
        assertEquals(sound2, instance.getSoundForState(new StateEvent(null, -1, state1)));
        assertEquals(null, instance.getSoundForState(new StateEvent(null, state1, state1)));
    }
    
}
