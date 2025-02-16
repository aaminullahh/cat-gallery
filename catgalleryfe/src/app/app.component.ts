import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  // title = 'catgalleryfe';
  cats: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchCats();
  }

  fetchCats(): void {
    this.http.get<any[]>('http://localhost:8080/cats').subscribe(data => {
      this.cats = data;
    });
  }

  uploadImage(event: any): void {
    const file = event.target.files[0];
    if (!file) return;
    
    const formData = new FormData();
    formData.append('file', file);
    
    this.http.post('http://localhost:8080/cats/upload', formData).subscribe(() => {
      this.fetchCats();
    });
  }

  deleteCat(id: string): void {
    this.http.delete(`http://localhost:8080/cats/${id}`).subscribe(() => {
      this.fetchCats();
    });
  }
}
