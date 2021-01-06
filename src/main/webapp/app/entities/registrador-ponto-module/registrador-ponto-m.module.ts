import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegistradorPontoComponent } from './registrador-ponto/registrador-ponto.component';
import { RegistradorPontoMRoutingModule } from './registrador-ponto-m-routing.module';

@NgModule({
  declarations: [RegistradorPontoComponent],
  imports: [HttpClientModule, CommonModule, RegistradorPontoMRoutingModule],
})
export class RegistradorPontoMModule {}
