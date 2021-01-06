import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';

import { RegistradorPontoService } from './registradorPonto.service';

@Component({
  selector: 'jhi-registrador-ponto',
  templateUrl: './registrador-ponto.component.html',
  styleUrls: ['./registrador-ponto.component.scss'],
})
export class RegistradorPontoComponent implements OnInit {
  results$: Observable<any>;

  constructor(private registradorPontoService: RegistradorPontoService) {
    this.results$ = new Observable<any>();
  }

  ngOnInit(): void {
    this.getRegistros();
  }

  getRegistros(): void {
    this.results$ = this.registradorPontoService.getAll();
  }
}
