/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ln;

/**
 *
 * @author Ondřej Kosour
 */
public class Chara {
    protected String name;
    protected String defSprite;

    public Chara(String name, String defSprite) {
        this.name = name;
        this.defSprite = defSprite;
    }

    public String getName() {
        return name;
    }
    
    public String getDefSprite() {
        return defSprite;
    }
    
}
