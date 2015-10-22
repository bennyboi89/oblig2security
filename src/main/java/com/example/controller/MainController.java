package com.example.controller;

import com.example.exception.ItemFoundException;
import com.example.model.Item;
import com.example.service.ItemService;
import com.example.service.impl.ItemServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;

/**
 * Created by benny on 21.10.15.
 */
@Controller
public class MainController {




    @Autowired
    private ItemServiceimp itemService;

    @RequestMapping(value = {"/","/login.html"}, method = RequestMethod.GET)
    public String getItemList(ModelMap model){
        model.addAttribute("itemList", itemService.itemList());

        return "index";
    }

    @RequestMapping(value = "/admin/dashboard/add", method = RequestMethod.GET)
    public @ResponseBody
    String addItem(
            @ModelAttribute Item item,
            ModelMap model,
            @RequestParam(value="navn") String navn,

            ServletRequest servletRequest){


        String result = "";

        item.setName(navn);

        itemService.insertNewItem(item);
        model.addAttribute("itemList", itemService.itemList());

        return result;


    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public @ResponseBody String updateItem(
            @ModelAttribute Item item,
            ModelMap model,
            @RequestParam(value = "id") String id,
            @RequestParam(value = "navn") String navn,
            @RequestParam(value = "beskrivelse") String beskrivelse){

        String result = "";

        if(StringUtils.hasText(item.getId())){
            item.setName(navn);

            itemService.updateItem(item);

            result+="<span style='margin-left:180px;' class='label label-success'>"
                    + "<i class=\"fa fa-check\"></i> Varen ble oppdatert!"
                    +"</span>";


        }else{
            result+="<span style='margin-left:180px;' class='label label-danger'>"
                    + "<i class=\"fa fa-exclamation-triangle\"></i> En feil oppsto ved oppdatering av varen!"
                    +"</span>";
        }

        return result;
    }



}