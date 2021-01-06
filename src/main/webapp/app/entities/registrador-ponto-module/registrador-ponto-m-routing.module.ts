import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistradorPontoComponent } from './registrador-ponto/registrador-ponto.component';

const routes: Routes = [
  {
    path: '',
    component: RegistradorPontoComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RegistradorPontoMRoutingModule {}
