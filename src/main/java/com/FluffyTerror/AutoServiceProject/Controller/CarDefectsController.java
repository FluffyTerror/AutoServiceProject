package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Service.CarOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view-car-defects")
public class CarDefectsController {

    @Autowired
    private CarOwnerService carOwnerService;

    @GetMapping
    public String listCarOwners(Model model) {
        model.addAttribute("owners", carOwnerService.getAllCarOwners());
        return "car-defects-owners";
    }

    @GetMapping("/{ownerId}/cars")
    public String listCars(@PathVariable Long ownerId, Model model) {
        model.addAttribute("cars", carOwnerService.getCarsByOwner(ownerId));
        return "car-defects-cars";
    }

    @GetMapping("/{ownerId}/cars/{carId}/defects")
    public String listResolvedDefects(@PathVariable Long carId, Model model) {
        model.addAttribute("defects", carOwnerService.getResolvedDefectsByCar(carId));
        return "car-defects-details";
    }
}