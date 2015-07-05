def process(relations)
  map = relations[0]
  1.upto(relations.length-1) do |i|
    index = map.index(relations[i][0])
    map.insert(index+1, relations[i][1])
  end
  map
end

test_count = gets.to_i
test_count.times do |j|
  courses = gets.split.map {|i| i.to_i}
  relations = []
  courses[1].times do
    relations << gets.split.map {|i| i.to_i}
  end
  length = process(relations).length
  if (length == courses[0])
    puts "Case #{j+1}: #{length} semester(s)"
  else
    puts "Case #{j+1}: Never Ends"
  end
end
