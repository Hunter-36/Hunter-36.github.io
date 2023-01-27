#
# Hunter Sutton
# Jacob Stone
#
require 'spec_helper'

describe 'C4 standard board size' do
    it 'detects P1 winning horizontally in row 0' do
        # Notice that the game should end before the last 'q' input is consumed
        result = test_c4('aabbccdq')
        expect(result).to declare_win_for 1
    end
    
    it 'quits before declaring a winner in column 0' do
        result = test_c4('abababq')
        expect(result).to be_abandoned
    end
    #no winner when only four values
    it 'detect invalid win from player 1; no winner declared' do
        result = test_c4('abdeq')
        expect(result).to be_abandoned
    end
     #win for vertical in row 2
    it 'detects P2 winning vertically in row 2' do
        result = test_c4('dcecfgdcec')
        expect(result).to declare_win_for 2
    end
    #win diagonally in row 0-3
    it 'detect P1 winning from ascending diagonal in row 0-3' do 
        result = test_c4('abbcdccdedd')
        expect(result).to declare_win_for 1
    end
    #win diagonally (descending) in row 0-3
    it 'detect P1 winning from descending diagonal in row 0-3' do 
        result = test_c4('dccbabbaaea')
        expect(result).to declare_win_for 1
    end
    #tie game for full board (player 0 win) draw case
    it 'tie game' do #only occurs at full board
        result = test_c4('aaaaaacccccceeeeeeggggggbdfbdfbdfbdfbdfbdf')
        expect(result).to declare_win_for 0 
    end
    #no winner when empty between values
    it 'no winner declared' do
        result = test_c4('aabbddeq')
        expect(result).to be_abandoned
    end
    #out of bounds column from user inputs
    it 'detects when out of bounds is inputed' do
        result = test_c4('aabbta')
        expect(result).to be_abandoned
    end
    #out of bounds column from user input
    it 'detects when player overflows a column, specifically column 1' do
        result = test_c4('aabbabaa')
        expect(result).to be_abandoned
    end
end


describe 'Connect 4 alternate' do
    it 'detects player 2 winning horizontally on a big board' do
        result = test_c4('iaabbccddeeffgq', 3, 9, 7)
        expect(result).to declare_win_for 2
    end
    #win for vertical in row 9
    it 'P1 winning vertically on a big board' do
        result = test_c4('jijijijiji', 6, 10, 5)
        expect(result).to declare_win_for 1
    end

    it 'quits before declaring a winner in column 0' do
        result = test_c4('iaabbccddeeffq', 3, 9, 7)
        expect(result).to be_abandoned
    end
    #win for ascending diagonal in row 5-9
    it 'P2 winning from ascending diagonal on a big board' do
        result = test_c4('gfhghhiiiijjjjhj', 6, 10, 5)
        expect(result).to declare_win_for 2 
    end

    #win for descending diagonal in row 
    it 'P1 winning from descending diagonal on a big board' do
        result = test_c4('aaaaabbbbccdcfdde', 6, 10, 5)
        expect(result).to declare_win_for 1
    end

    #tie game for a full board
    it 'tie game on a big board' do
        result = test_c4('aaaaaacccccceeeeeeggggggiiiiiibbbbbbddddddffffffhhhhhhjjjjjj', 6, 10, 7)
        expect(result).to declare_win_for 0 # any tie case allows for player 0 or a draw to win
    end

    #win for 1 and not let player 2 move after if they try
    it 'win and not let other person move' do
        result = test_c4('aabbccddeeffggq', 7, 7, 5) # the last g is for player 2 and should not go
        expect(result).to declare_win_for 1
    end

    #invalid input
    it 'invalid input on a small board' do
        result = test_c4('aabgbccq', 6, 5, 3) #g is invalid
        expect(result).to be_abandoned
    end

end

