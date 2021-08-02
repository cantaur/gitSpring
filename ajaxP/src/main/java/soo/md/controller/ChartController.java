package soo.md.controller;


import com.sun.jmx.remote.internal.ArrayQueue;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import soo.md.domain.ChartDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("chart")
public class ChartController {

    @GetMapping("chart.do")
    public  String showView(){
        return "chart/chart";
    }

    private Random r = new Random();

    @ResponseBody
    @PostMapping(value = "chartData", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<ChartDTO> getChartData(){
        List<ChartDTO> list = new ArrayList<ChartDTO>();
        String items[] = {"봄", "여름", "가을", "겨울"};
        for(int i=0; i<items.length; i++){
            int number = r.nextInt(50);
            ChartDTO dto = new ChartDTO(items[i], number);
            list.add(dto);
        }
        return list;

    }
}
