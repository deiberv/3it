import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { Chart, ChartConfiguration } from 'chart.js';
import { ChartSerie } from 'src/app/models/chart-serie';
import { SurveyResultResponse } from 'src/app/models/survey-result-response';

@Component({
  selector: 'app-survey-results-chart',
  templateUrl: './survey-results-chart.component.html',
  styleUrls: ['./survey-results-chart.component.scss']
})
export class SurveyResultsChartComponent implements OnInit {

  @Input() results:SurveyResultResponse[] | undefined;
  
  multi: any[];
  view: any[] = [700, 400];

  // options
  showXAxis: boolean = true;
  showYAxis: boolean = true;
  gradient: boolean = true;
  showLegend: boolean = true;
  showXAxisLabel: boolean = true;
  xAxisLabel: string = 'Country';
  showYAxisLabel: boolean = true;
  yAxisLabel: string = 'Population';
  legendTitle: string = 'Years';

  colorScheme = {
    domain: ['#5AA454', '#C7B42C', '#AAAAAA']
  };

  constructor() { 
    this.multi = [];
  }

  ngOnInit(): void {

    this.initChart();
  }

  initChart(): void
  {
    this.multi = [
      {
        "name": "Germany",
        "value": 8940000
      },
      {
        "name": "USA",
        "value": 5000000
      }
    ];
  }
}
