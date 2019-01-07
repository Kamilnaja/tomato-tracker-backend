var Dungeon = function (cells) {
    this.cells = cells;
    this.bookedCells = 0;
}

var dungeons = {}
Dungeon.find = function (id, callback) {
    if (!dungeons[id]) {
        dungeons[id] = new Dungeon(100);
    }
    callback(null, dungeons[id])
}