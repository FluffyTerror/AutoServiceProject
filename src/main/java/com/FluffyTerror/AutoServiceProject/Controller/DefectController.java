package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Model.Defect;
import com.FluffyTerror.AutoServiceProject.Model.Car;
import com.FluffyTerror.AutoServiceProject.Repository.CarRepository;
import com.FluffyTerror.AutoServiceProject.Repository.DefectRepository;
import com.FluffyTerror.AutoServiceProject.Service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DefectController {

    @Autowired
    private DefectRepository defectRepository;

    @Autowired

    private CarRepository carRepository;
    @Autowired
    private DefectService defectService;

    // Список всех дефектов
    @GetMapping("/defects-owners")
    public String getAllDefects(Model model) {
        model.addAttribute("defects", defectRepository.findAll());
        return "defects-list"; // Шаблон для списка дефектов
    }

    // Владельцы по описанию дефекта
    @GetMapping("/defects-owners/{id}")
    public String getOwnersByDefect(@PathVariable Long id, Model model) {
        Defect defect = defectRepository.findById(id).orElse(null);
        if (defect == null) {
            model.addAttribute("errorMessage", "Дефект с указанным ID не найден.");
            return "error-page";
        }
        model.addAttribute("defect", defect); // Передаем информацию о дефекте
        model.addAttribute("owners", defectService.getOwnersByDefectId(id)); // Владельцы с этим дефектом
        return "defect-owners";
    }

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