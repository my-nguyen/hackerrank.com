# version 1: use recursion: 2^100-deep recursion is too much!
def last_stone(stones, a, b)
  # special case
  if stones == 1
    return [a, b]
  else
    array = []
    last_stone(stones-1, a, b).each do |element|
      array << a+element << b+element
    end
    return array
  end
end

gets.strip.to_i.times do
  stones = gets.strip.to_i
  a = gets.strip.to_i
  b = gets.strip.to_i
  last_stone(stones-1, a, b).sort.uniq.each do |element|
    print("#{element} ")
  end
  puts
end
