package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Model.Defect;
import com.FluffyTerror.AutoServiceProject.Model.Car;
import com.FluffyTerror.AutoServiceProject.Repository.CarRepository;
import com.FluffyTerror.AutoServiceProject.Repository.DefectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DefectController {

    @Autowired
    private DefectRepository defectRepository;

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/defects/add")
    public String showAddDefectForm(Model model) {
        model.addAttribute("defect", new Defect());
        model.addAttribute("cars", carRepository.findAll()); // Список авто для выбора
        return "add-defect";
    }

    @PostMapping("/defects/add")
    public String addDefect(@ModelAttribute("defect") Defect defect, Model model) {
        defectRepository.save(defect);
        model.addAttribute("message", "Дефект успешно добавлен!");
        return "add-defect";
    }
}