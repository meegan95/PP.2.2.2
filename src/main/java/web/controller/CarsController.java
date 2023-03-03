package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private CarDao carDao;
    @Autowired
    public CarsController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping()
    public String index(@RequestParam (value = "count", required = false) Integer count, Model model){
        //все машины
        if (count != null) {
            model.addAttribute("cars", carDao.index(count));
        } else {
        model.addAttribute("cars", carDao.index());
        }
        return "cars/index";

    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
        //машина по id
        model.addAttribute("car", carDao.show(id));
        return "cars/show";
    }

}
