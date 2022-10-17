package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.Rate;
import com.company.projektHipoteczny.model.Summary;

import java.util.List;

public interface SummaryService {

    Summary calculate(List<Rate> rates);
}
