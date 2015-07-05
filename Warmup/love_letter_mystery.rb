def love_letter(string)
  count = 0
  0.upto(string.length/2-1) do |left|
    # right index operates from right to left
    right = -1 - left
    # increase count by the absolute difference in the 2 characters found
    # at left and right indices
    count += (string[right].ord - string[left].ord).abs
  end
  return count
end

gets.to_i.times do
  puts(love_letter(gets.strip))
end
