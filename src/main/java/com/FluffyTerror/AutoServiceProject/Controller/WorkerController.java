package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Model.Worker;
import com.FluffyTerror.AutoServiceProject.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping("/workers/add")
    public String showAddWorkerForm(Model model) {
        model.addAttribute("worker", new Worker());
        return "add-worker";
    }

    @PostMapping("/workers/add")
    public String addWorker(@ModelAttribute("worker") Worker worker, Model model) {
        workerRepository.save(worker);
        model.addAttribute("message", "Работник успешно добавлен!");
        return "add-worker";
    }
}