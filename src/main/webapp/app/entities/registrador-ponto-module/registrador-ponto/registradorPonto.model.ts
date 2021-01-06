export interface IRegistradorPonto {
  usuario?: IUsuario;
  instante?: String;
}

export interface IUsuario {
  id?: Number;
  firstName?: String;
}

export class RegistradorPonto implements IRegistradorPonto {
  constructor(public usuario: IUsuario, public instante: any) {}
}
