import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { SERVER_API_URL } from 'app/app.constants';
import { IRegistradorPonto } from './registradorPonto.model';

@Injectable({ providedIn: 'root' })
export class RegistradorPontoService {
  public resourceUrlPost = SERVER_API_URL + 'api/ponto';
  public resourceUrlGetAll = `${SERVER_API_URL} api/pontos/${localStorage.getItem('jhi-id')}`;

  constructor(private http: HttpClient) {}

  create(registradorPonto: IRegistradorPonto): void {
    this.http.post(this.resourceUrlPost, registradorPonto).subscribe();
  }

  getAll(): Observable<IRegistradorPonto[]> {
    return this.http.get(this.resourceUrlGetAll).pipe(
      map((data: any) => {
        const registros: Array<any> = [];

        for (const registro of data) {
          if (data) {
            registro.instante =
              new Date(registro.instante).toLocaleTimeString() + ' - ' + new Date(registro.instante).toLocaleDateString('pt-BR');

            registros.push(registro);
          }
        }
        return registros;
      })
    );
  }
}
