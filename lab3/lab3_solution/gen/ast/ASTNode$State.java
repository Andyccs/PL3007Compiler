package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @apilevel internal
  * @ast class
 * 
 */
public class ASTNode$State extends java.lang.Object {

/**
 * @apilevel internal
 */
  public boolean IN_CIRCLE = false;


/**
 * @apilevel internal
 */
  public int CIRCLE_INDEX = 1;


/**
 * @apilevel internal
 */
  public boolean CHANGE = false;


/**
 * @apilevel internal
 */
  public boolean LAST_CYCLE = false;


/**
 * @apilevel internal
 */
  public boolean RESET_CYCLE = false;


  /**
   * @apilevel internal
   */
  static public class CircularValue {
    Object value;
    int visited = -1;
  }


  /**
   * @apilevel internal
   */
  static class IdentityHashSet extends java.util.AbstractSet implements java.util.Set {
    public IdentityHashSet(int initialCapacity) {
      map = new java.util.IdentityHashMap(initialCapacity);
      }
    private java.util.IdentityHashMap map;
    private static final Object PRESENT = new Object();
    public java.util.Iterator iterator() { return map.keySet().iterator(); }
    public int size() { return map.size(); }
    public boolean isEmpty() { return map.isEmpty(); }
    public boolean contains(Object o) { return map.containsKey(o); }
    public boolean add(Object o) { return map.put(o, PRESENT)==null; }
    public boolean remove(Object o) { return map.remove(o)==PRESENT; }
    public void clear() { map.clear(); }
  }

public void reset() {
    IN_CIRCLE = false;
    CIRCLE_INDEX = 1;
    CHANGE = false;
    LAST_CYCLE = false;
  }


}
