# version 2: replacing recursion with iteration: array of 2^100 elements
# each being a FixNum or BigNum is still too much!
def last_stone(stones, a, b)
  array = [a, b]
  puts("stones: #{stones}")
  (stones-2).times do
    length = array.length
    puts("length: #{length}")
    length.times do |index|
      array << array[index] + a
      array[index] += b
    end
  end
  return array
end

gets.strip.to_i.times do
  stones = gets.strip.to_i
  a = gets.strip.to_i
  b = gets.strip.to_i
  last_stone(stones, a, b).sort.uniq.each do |element|
    print("#{element} ")
  end
  puts
end
