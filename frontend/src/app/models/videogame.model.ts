export class Videogame {
    constructor(
        private _id: number,
        private _name: string,
        private _image: string,
        private _genre: string,
        private _review: string,
        private _rate: number
    ) {}

    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    public get image(): string {
        return this._image;
    }
    public set image(value: string) {
        this._image = value;
    }
    public get genre(): string {
        return this._genre;
    }
    public set genre(value: string) {
        this._genre = value;
    }
    public get review(): string {
        return this._review;
    }
    public set review(value: string) {
        this._review = value;
    }
    public get rate(): number {
        return this._rate;
    }
    public set rate(value: number) {
        this._rate = value;
    }

    public toJSON(): object {
        return {
            id: this._id,
            name: this._name,
            image: this._image,
            genre: this._genre,
            review: this._review,
            rate: this._rate
        };
    }
}