/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

/**
 *
 * @author VivoBook
 */
public class MVC {
    View view = new View();
    Model model = new Model();
    Controller controller = new Controller(view, model);
}
