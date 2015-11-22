package br.unisinos.lab2.mindmap;


import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.unisinos.lab2.mindmap.MindMap;

@RunWith(JUnit4.class)
public class MindMapTest {
  @Test
  public void testFindInRoot() {
    MindMap<String> mind = new MindMap<>();
    DNode<String> root = new DNode<String>("Root");
    mind.setRoot(root);
    assertEquals(root, mind.getElement("Root"));
  }
  @Test
  public void testFindInOneLevel() {
    MindMap<String> mind = new MindMap<>();
    DNode<String> root  = new DNode<String>("Root");
    DNode<String> br1   = new DNode<String>("br1");
    DNode<String> br11  = new DNode<String>("br11");
    DNode<String> br2   = new DNode<String>("br2");
    DNode<String> br21  = new DNode<String>("br21");
    DNode<String> br22  = new DNode<String>("br22");
    DNode<String> br23  = new DNode<String>("br23");
    DNode<String> br221 = new DNode<String>("br221");
    DNode<String> br222 = new DNode<String>("br222");
    DNode<String> br223 = new DNode<String>("br223");
    DNode<String> br231 = new DNode<String>("br231");
    DNode<String> br232 = new DNode<String>("br232");
    DNode<String> br233 = new DNode<String>("br233");
    DNode<String> br3   = new DNode<String>("br3");
    DNode<String> br4   = new DNode<String>("br4");
    DNode<String> br41  = new DNode<String>("br41");
    DNode<String> br42  = new DNode<String>("br42");
    
    root.setSon(br1);
    br1.setBro(br2);
    br2.setBro(br3);
    br3.setBro(br4);
    
    br1.setSon(br11);
    
    br2.setSon(br21);
    br21.setBro(br22);
    br22.setBro(br23);
    
    br22.setSon(br221);
    br221.setBro(br222);
    br222.setBro(br223);
    
    br23.setSon(br231);
    br231.setBro(br232);
    br232.setBro(br233);
    
    br4.setSon(br41);
    br41.setBro(br42);
    
    mind.setRoot(root);
    
    assertEquals(root , mind.getElement("Root"));
    assertEquals(br1  , mind.getElement("br1"));
    assertEquals(br11 , mind.getElement("br11"));
    assertEquals(br2  , mind.getElement("br2"));
    assertEquals(br21 , mind.getElement("br21"));
    assertEquals(br22 , mind.getElement("br22"));
    assertEquals(br23 , mind.getElement("br23"));
    assertEquals(br221, mind.getElement("br221"));
    assertEquals(br222, mind.getElement("br222"));
    assertEquals(br223, mind.getElement("br223"));
    assertEquals(br231, mind.getElement("br231"));
    assertEquals(br232, mind.getElement("br232"));
    assertEquals(br233, mind.getElement("br233"));
    assertEquals(br3  , mind.getElement("br3"));
    assertEquals(br4  , mind.getElement("br4"));
    assertEquals(br41 , mind.getElement("br41"));
    assertEquals(br42 , mind.getElement("br42"));
    
    assertEquals(null, mind.getElement("batta"));
  }
}
