class Map
  def initialize
    @data = []
  end

  def push(string)
    @data << string
  end

  def cavity()
    (1..@data.length-2).each do |row|
      (1..@data[row].length-2).each do |column|
        current = @data[row][column]
        # compare the current cell with the 4 adjacent cells: up, down, left,
        # and right. If current cell is strictly greater than all 4 cells, then
        # mark current cell with an 'X'
        if (@data[row-1][column] < current) && (@data[row+1][column] < current) &&
           (@data[row][column-1] < current) && (@data[row][column+1] < current)
          @data[row][column] = 'X'
        end
      end
    end
    return @data
  end

  def to_s()
    string = ""
    @data.each do |row|
      string << "#{row}\n"
    end
    return string
  end
end

map = Map.new
gets.to_i.times do
  map.push(gets.strip)
end

puts(map.cavity)
