import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Videogame } from '../models/videogame.model';

@Injectable({
  providedIn: 'root'
})
export class VideogamesService {

  readonly API_URL = 'http://localhost:8080';

  constructor(
    private http: HttpClient
  ) { }

postVideogame(videogame: Videogame): Observable<Videogame> {
  return this.http.post<any>(this.API_URL + '/games', videogame);

}
findGame(videogameName:string): Observable<any> {
  return this.http.get<Videogame>(this.API_URL + '/games/' + videogameName);
}
deleteVideogame(videogameId :number): Observable<Videogame> {
  return this.http.delete<Videogame>(this.API_URL + '/games/' + videogameId);
}
}
