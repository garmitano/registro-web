package com.resdelgado.registro.mvc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.resdelgado.registro.service.ITipoService;

@Controller
@RequestMapping("/tipos")
public class TipoMvcController {

    @Autowired
    ITipoService tipoService;

    @GetMapping("/show")
    public ModelAndView show() {

        var params = new HashMap<String, Object>();
        params.put("listTipos", tipoService.getAll());

        return new ModelAndView("tipos", params);

    }
}
