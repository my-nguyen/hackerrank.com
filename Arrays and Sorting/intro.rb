def process(array, value)
  return array.index(value)
end

value = gets.to_i
array_size = gets.to_i
array = gets.split.map {|i| i.to_i}

puts(process(array, value))
