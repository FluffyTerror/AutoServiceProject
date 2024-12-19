package com.FluffyTerror.AutoServiceProject.Controller;

import com.FluffyTerror.AutoServiceProject.Model.Repair;
import com.FluffyTerror.AutoServiceProject.Repository.WorkerRepository;
import com.FluffyTerror.AutoServiceProject.Service.DefectService;
import com.FluffyTerror.AutoServiceProject.Service.RepairService;
import com.FluffyTerror.AutoServiceProject.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @Autowired
    private DefectService defectService;

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private WorkerService workerService;

    @GetMapping("/create")
    public String showCreateRepairForm(Model model) {
        model.addAttribute("repair", new Repair());
        model.addAttribute("defects", defectService.getAllDefects());
        model.addAttribute("workers",workerRepository.findAll());
        return "create-repair";
    }

    @PostMapping("/create")
    public String createRepair(@ModelAttribute Repair repair) {
        repairService.createRepair(repair);
        return "redirect:/repair-worker";
    }

    @GetMapping
    public String getAllWorkers(Model model) {
        model.addAttribute("workers", workerService.getAllWorkers());
        return "workers-list"; // Шаблон для отображения списка работников
    }

    // Ремонты, выполненные конкретным работником
    @GetMapping("/{workerId}")
    public String getRepairsByWorker(@PathVariable Long workerId, Model model) {
        model.addAttribute("repairs", repairService.getRepairsByWorkerId(workerId));
        model.addAttribute("worker", workerService.getWorkerById(workerId));
        return "worker-repairs"; // Шаблон для отображения ремонтов конкретного работника
    }
    @GetMapping("/delete")
    public String showWorkersForDeletion(Model model) {
        model.addAttribute("workers", workerService.getAllWorkers());
        return "delete-worker-list"; // Шаблон для отображения списка работников
    }

    @GetMapping("/delete/{workerId}")
    public String deleteWorker(@PathVariable Long workerId) {
        workerService.deleteWorkerById(workerId);
        return "redirect:/repair/delete"; // Перенаправление на список после удаления
    }
}
