package br.com.example.controller;

import br.com.example.exceptions.UnsupportedMathOperationException;
import br.com.example.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    private MathService mathService;
    @Autowired
    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne")String numberOne,
    @PathVariable(value = "numberTwo")String numberTwo) throws Exception {

        if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return mathService.convertToDouble(numberOne) + mathService.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberOne")String numberOne,
                      @PathVariable(value = "numberTwo")String numberTwo) throws Exception {

        if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return mathService.convertToDouble(numberOne) - mathService.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne")String numberOne,
                      @PathVariable(value = "numberTwo")String numberTwo) throws Exception {

        if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return mathService.convertToDouble(numberOne) / mathService.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberOne")String numberOne,
                           @PathVariable(value = "numberTwo")String numberTwo) throws Exception {

        if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return mathService.convertToDouble(numberOne) * mathService.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double average(@PathVariable(value = "numberOne")String numberOne,
                           @PathVariable(value = "numberTwo")String numberTwo) throws Exception {

        if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return (mathService.convertToDouble(numberOne) + mathService.convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping(value = "/squareRoot/{numberOne}",method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "numberOne")String numberOne) throws Exception {

        if(!mathService.isNumeric(numberOne)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return Math.sqrt(mathService.convertToDouble(numberOne));
    }

}
