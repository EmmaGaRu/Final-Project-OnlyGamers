export class Review {

    constructor(
        private _id: number,
        private _userName: string,
        private _comment: string,
        private _rate: number,
        private _gameName: string,
    ) {}

    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get userName(): string {
        return this._userName;
    }
    public set userName(value: string) {
        this._userName = value;
    }
    public get comment(): string {
        return this._comment;
    }
    public set comment(value: string) {
        this._comment = value;
    }
    public get gameName(): string {
        return this._gameName;
    }
    public set gameName(value: string) {
        this._gameName = value;
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
            userName: this._userName,
            comment: this._comment,
            gameName: this._gameName,
        };
    }
}