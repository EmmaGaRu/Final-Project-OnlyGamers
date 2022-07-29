import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from '../models/review.model';

@Injectable({
  providedIn: 'root'
})
export class ReviewsService {
  readonly API_URL = 'http://localhost:8080';

  constructor(
    private http: HttpClient
  ) { }

addReview(review: Review): Observable<Review> {
  return this.http.post<Review>(`${this.API_URL}/review`, review);
  // const username = JSON.parse(localStorage.getItem("currentUser") as string).username;
  // const password = JSON.parse(localStorage.getItem("currentUser") as string).password;

  // let headers = new HttpHeaders();
  // headers = headers.append('Authorization', 'Basic ' + btoa(`${username}:${password}`));

  // return this.http.post<any>(this.API_URL + '/review', review, { headers: headers });

}

ranking(): Observable<any> {
  return this.http.get<Review>(this.API_URL + '/findMeanUsersRate');
}

}

// addReview(review: Review): Observable<Review> {
//   return this.http.post<Review>(`${this.API_URL}/review`, review);

// }
